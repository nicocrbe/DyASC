import machine

led_conexion = machine.Pin(13, machine.Pin.OUT)
led_build_ok = machine.Pin(22, machine.Pin.OUT)
led_build_fail = machine.Pin(23, machine.Pin.OUT)
led_desconexion = machine.Pin(26, machine.Pin.OUT)
buzzer = machine.Pin(25, machine.Pin.OUT)