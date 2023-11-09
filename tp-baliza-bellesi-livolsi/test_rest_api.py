import unittest
from unittest import TestCase
from unittest.mock import MagicMock, patch
from Services.RestTest import start_server
import Services.GithubStatusTest
from Configuration.Constants import log_solicitud_post_recibida

class TestRestApi(TestCase):

    @patch('builtins.print')  # Patch print
    def test_start_server_with_mock_request(self, mock_print):
        
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                {"conclusion": "success"}
            ]
        }

        # mock urequests.get
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get
        # mock request 
        mock_request = b'POST /estado HTTP/1.1\r\nHost: example.com\r\n\r\n'

        # mock socket
        mock_socket = MagicMock()
        mock_socket.recv.return_value = mock_request

        # mock conn y addr
        mock_conn = MagicMock()
        mock_addr = ("192.168.1.100", 12345)   

        # Patch s.accept() call
        mock_socket.accept.return_value = (mock_conn, mock_addr)
        
        # start_server con the mock socket
        start_server(mock_socket)

        # Check log_solicitud_post_recibida
        mock_print.assert_called_with(log_solicitud_post_recibida)

if __name__ == '__main__':
    unittest.main()
