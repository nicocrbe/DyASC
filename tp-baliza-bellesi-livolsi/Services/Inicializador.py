from Config.PinConfig import led_build_fail, led_build_ok, led_conexion, led_desconexion, buzzer
import time

def inicializar():
    led_build_ok.value(1)
    led_build_fail.value(1)
    led_conexion.value(1)
    led_desconexion.value(1)
    buzzer.value(1)

    time.sleep(0.25)

    led_build_ok.value(0)
    led_build_fail.value(0)
    led_conexion.value(0)
    led_desconexion.value(0)
    buzzer.value(0)
