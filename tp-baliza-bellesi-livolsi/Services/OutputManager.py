from Config.PinConfig import led_build_fail, led_build_ok, led_conexion, led_desconexion, buzzer
import time

def build_ok_output():
    led_build_ok.value(1)
    led_build_fail.value(0)

def build_fail_output():
    led_build_fail.value(1)
    led_build_ok.value(0)

def conexion_output():
    led_conexion.value(1)
    led_desconexion.value(0)

def desconexion_output():
    led_desconexion.value(1)
    led_conexion.value(0)

def buzzer_output():
    buzzer.value(1)
    time.sleep(0.25)
    buzzer.value(0)

def waiting_status(tiempo):
    start_time = time.time()
    while time.time() - start_time < tiempo:
        if led_build_ok.value() == 1:
            led_build_ok.value(0)
            time.sleep(0.25)
            led_build_ok.value(1)
        elif led_build_fail.value() == 1:
            led_build_fail.value(0)
            time.sleep(0.25)
            led_build_fail.value(1)
        time.sleep(0.25)