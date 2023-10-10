import network
import time
from Services.OutputManager import desconexion_output
from Configuration.RestConfig import ssid, password
from Configuration.Constants import log_conexion_exitosa, log_error_conexion, log_desconexion

def connect():
    global station
    try:
        station = network.WLAN(network.STA_IF)
        station.active(True)
        station.connect(ssid, password)
        while station.isconnected() == False:
            print(log_desconexion)
            desconexion_output()
            station = connect()
        print(log_conexion_exitosa)
        print('Direccion IP :', station.ifconfig()[0])
    except OSError:
        print(log_error_conexion)
        time.sleep(10)
        station = connect()
    finally:
        return station