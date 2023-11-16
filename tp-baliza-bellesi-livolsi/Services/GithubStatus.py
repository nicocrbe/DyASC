import sys
import time

class MockPin:
    def __init__(self):
        self._value = 0

    def value(self, val=None):
        if val is not None:
            self._value = val
        return self._value
    
class MockUrequests:
    @staticmethod
    def get(url, headers):
        # Proporciona una implementación de reemplazo según sea necesario para las pruebas
        pass
    
class MockOutputManager:
    led_build_fail = MockPin()
    led_build_ok = MockPin()
    led_conexion = MockPin()
    led_desconexion = MockPin()
    buzzer = MockPin()

    def build_ok_output(self):
        self.led_build_ok.value(1)
        self.led_build_fail.value(0)

    def build_fail_output(self):
        self.led_build_fail.value(1)
        self.led_build_ok.value(0)

    def conexion_output(self):
        self.led_conexion.value(1)
        self.led_desconexion.value(0)

    def desconexion_output(self):
        self.led_desconexion.value(1)
        self.led_conexion.value(0)

    def buzzer_output(self):
        self.buzzer.value(1)
        time.sleep(0.25)
        self.buzzer.value(0)

    def waiting_status(self, tiempo):
        start_time = time.time()
        while time.time() - start_time < tiempo:
            if self.led_build_ok.value() == 1:
                self.led_build_ok.value(0)
                time.sleep(0.25)
                self.led_build_ok.value(1)
            elif self.led_build_fail.value() == 1:
                self.led_build_fail.value(0)
                time.sleep(0.25)
                self.led_build_fail.value(1)
            time.sleep(0.25)

if 'esp' in sys.platform:
    # ejecutando en MicroPython, realiza las importaciones normales
    import urequests
    from Services.OutputManager import build_fail_output, build_ok_output, buzzer_output, waiting_status    
    from Configuration.PinConfig import led_build_fail, led_build_ok, led_conexion, led_desconexion, buzzer
else:
    # ejecutando en un entorno de prueba, utiliza las versiones mock
    urequests = MockUrequests()
    led_build_fail = MockOutputManager.led_build_fail
    led_build_ok = MockOutputManager.led_build_ok
    led_conexion = MockOutputManager.led_conexion
    led_desconexion = MockOutputManager.led_desconexion
    buzzer = MockOutputManager.buzzer

from Configuration.Constants import log_build_exitoso, log_build_fallido, log_no_workflows, log_fallo_json, log_fallo_request_datos
from Configuration.RestConfig import usuario, repositorio, user_agent
from Secrets import token

def get_status(tiempo):
    MockOutputManager.waiting_status(tiempo)
    
    url = "https://api.github.com/repos/" + usuario + "/" + repositorio + "/" + "actions/runs?page=1&per_page=1"

    searchHeaders = {
        "User-Agent": user_agent,
        "Authorization": token
    }

    response = urequests.get(url, headers=searchHeaders)

    if response.status_code == 200:
        try:
            parsed_data = response.json()
            if "workflow_runs" in parsed_data and len(parsed_data["workflow_runs"]) > 0:
                first_workflow = parsed_data["workflow_runs"][0]
                
                if(first_workflow["conclusion"] == "success"):
                    print(log_build_exitoso)
                    if(MockOutputManager.led_build_fail.value() == 1):
                        MockOutputManager.buzzer_output()
                    MockOutputManager.build_ok_output()
                elif(first_workflow["conclusion"] == "failure"):
                    print(log_build_fallido)
                    if(MockOutputManager.led_build_ok.value() == 1):
                        MockOutputManager.buzzer_output()
                    MockOutputManager.build_fail_output()
            else:
                print(log_no_workflows)
        except ValueError:
            print(log_fallo_json)
        finally:
            response.close()
    else:
        print(f"{log_fallo_request_datos} {response.status_code}")
