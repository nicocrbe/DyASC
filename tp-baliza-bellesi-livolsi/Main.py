from Services.OutputManager import conexion_output, desconexion_output
from Services.Rest import start_server
from Services.ConectorWifi import connect
from Services.Inicializador import inicializar

station = None
inicializar()
station = connect()

while True:
    if(station.isconnected()):
        conexion_output()
        start_server()
    else:
        desconexion_output()
        station = connect()
