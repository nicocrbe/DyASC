from Services.GithubStatus import get_status
from Config.RestConfig import path
from Config.Constants import log_solicitud_post_recibida, log_error_conexion
import socket

def start_server():
    get_status(2)
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind(('', 80))
    s.listen(5)
    
    while True:
        try:
            conn, addr = s.accept()
            request = conn.recv(1024)
            
            if 'POST ' + path  in str(request):
                print(log_solicitud_post_recibida)
                get_status(30)
        except OSError:
            print(log_error_conexion)
        finally:
            conn.close()