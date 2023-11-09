import unittest
from unittest import TestCase
from unittest.mock import MagicMock, patch
from Services.RestTest import start_server
import Services.GithubStatusTest
from Configuration.Constants import log_solicitud_post_recibida

class TestRestApi(TestCase):

    @patch('builtins.print')  # Patch the built-in print function
    def test_start_server_with_mock_request(self, mock_print):
        # Create a mock response object
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                {"conclusion": "success"}
            ]
        }

        # Create a mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # Monkey patch urequests.get with the mock function
        
        Services.GithubStatusTest.urequests.get = mock_get
        # Create a mock request object
        mock_request = b'POST /estado HTTP/1.1\r\nHost: example.com\r\n\r\n'

        # Create a mock socket object
        mock_socket = MagicMock()
        mock_socket.recv.return_value = mock_request

        # Create mock values for conn and addr
        mock_conn = MagicMock()
        mock_addr = ("192.168.1.100", 12345)   

        # Patch the s.accept() call
        mock_socket.accept.return_value = (mock_conn, mock_addr)
        
        # Call the start_server function with the mock socket
        start_server(mock_socket)

        # Check if log_solicitud_post_recibida was printed
        mock_print.assert_called_with(log_solicitud_post_recibida)

if __name__ == '__main__':
    unittest.main()
