from Services.GithubStatusTest import get_status
from Configuration.RestConfig import path
from Configuration.Constants import log_solicitud_post_recibida, log_error_conexion
import socket

def start_server(mock_socket=None):
    get_status()
    s = mock_socket or socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind(('', 80))
    s.listen(5)
    
    while True:
        try:
            conn, addr = s.accept()
            request = conn.recv(1024)
            print(request)
            if 'POST ' + path  in str(request):
                print(log_solicitud_post_recibida)
                get_status()
        except OSError:
            print(log_error_conexion)
        finally:
            conn.close()