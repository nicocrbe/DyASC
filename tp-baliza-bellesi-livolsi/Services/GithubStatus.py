import urequests
from Configuration.Constants import log_build_exitoso, log_build_fallido, log_no_workflows, log_fallo_json, log_fallo_request_datos
from Configuration.PinConfig import led_build_fail, led_build_ok
from Services.OutputManager import build_fail_output, build_ok_output, buzzer_output, waiting_status
from Configuration.RestConfig import usuario, repositorio, user_agent
from Secrets import token

def get_status(tiempo):
    waiting_status(tiempo)
    
    url = "https://api.github.com/repos/" + usuario + repositorio + "actions/runs?page=1&per_page=1"
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
                    if(led_build_fail.value() == 1):
                        buzzer_output()
                    build_ok_output()
                elif(first_workflow["conclusion"] == "failure"):
                    print(log_build_fallido)
                    if(led_build_ok.value() == 1):
                        buzzer_output()
                    build_fail_output()
            else:
                print(log_no_workflows)
        except ValueError:
            print(log_fallo_json)
        finally:
            response.close()
    else:
        print(log_fallo_request_datos, response.status_code)