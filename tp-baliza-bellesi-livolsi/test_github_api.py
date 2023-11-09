import unittest
from unittest import TestCase
from unittest.mock import MagicMock, patch
import Services.GithubStatusTest
from Configuration.Constants import log_build_exitoso, log_build_fallido, log_no_workflows, log_fallo_json, log_fallo_request_datos


class TestGithubApi(TestCase):

    def test_get_status_con_mock_response_Build_exitoso(self):
        
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                {"conclusion": "success"}
            ]
        }

        # mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get


        # Capturo print
        with patch('builtins.print') as mock_print:
            # llamo get_status
            Services.GithubStatusTest.get_status()

        # Check log_build_exitoso
        mock_print.assert_called_with(log_build_exitoso)

    def test_get_status_con_mock_response_Build_fallido(self):
        
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                {"conclusion": "failure"}
            ]
        }

        # mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get


        # Capturo print
        with patch('builtins.print') as mock_print:
            # llamo get_status
            Services.GithubStatusTest.get_status()

        # Check log_build_fallido
        mock_print.assert_called_with(log_build_fallido)    

    def test_get_status_con_mock_response_No_Workflows(self):
        
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                
            ]
        }

        # mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get


        # Capturo print
        with patch('builtins.print') as mock_print:
            # llamo get_status
            Services.GithubStatusTest.get_status()

        # Check log_no_workflows
        mock_print.assert_called_with(log_no_workflows) 

    def test_get_status_con_mock_response_Fallo_JSON(self):
        
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.side_effect = ValueError("Invalid JSON")


        # mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get


        # Capturo print
        with patch('builtins.print') as mock_print:
            # llamo get_status
            Services.GithubStatusTest.get_status()

        # Check log_fallo_json
        mock_print.assert_called_with(log_fallo_json) 

    def test_get_status_con_mock_response_Fallo_Request(self):
        
        mock_response = MagicMock()
        mock_response.status_code = 404


        # mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # patch urequests.get con mock function
        
        Services.GithubStatusTest.urequests.get = mock_get


        # Capturo print
        with patch('builtins.print') as mock_print:
            # llamo get_status
            Services.GithubStatusTest.get_status()

        # Check log_fallo_requests_datos
        mock_print.assert_called_with(f"{log_fallo_request_datos} 404") 

if __name__ == '__main__':
    unittest.main()
