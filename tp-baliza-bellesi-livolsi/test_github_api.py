import unittest
from unittest import TestCase
from unittest.mock import MagicMock, patch
import Services.GithubStatusTest
from Configuration.Constants import log_build_exitoso, log_build_fallido, log_no_workflows, log_fallo_json, log_fallo_request_datos


class TestGithubApi(TestCase):

    def test_get_status_with_mock_response_Build_exitoso(self):
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


        # Capture print statements using a context manager
        with patch('builtins.print') as mock_print:
            # Call the get_status function
            Services.GithubStatusTest.get_status()

        # Check if log_build_exitoso was printed
        mock_print.assert_called_with(log_build_exitoso)

    def test_get_status_with_mock_response_Build_fallido(self):
        # Create a mock response object
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                {"conclusion": "failure"}
            ]
        }

        # Create a mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # Monkey patch urequests.get with the mock function
        import Services.GithubStatusTest
        Services.GithubStatusTest.urequests.get = mock_get


        # Capture print statements using a context manager
        with patch('builtins.print') as mock_print:
            # Call the get_status function
            Services.GithubStatusTest.get_status()

        # Check if log_build_fallido was printed
        mock_print.assert_called_with(log_build_fallido)    

    def test_get_status_with_mock_response_No_Workflows(self):
        # Create a mock response object
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = {
            "workflow_runs": [
                
            ]
        }

        # Create a mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # Monkey patch urequests.get with the mock function
        import Services.GithubStatusTest
        Services.GithubStatusTest.urequests.get = mock_get


        # Capture print statements using a context manager
        with patch('builtins.print') as mock_print:
            # Call the get_status function
            Services.GithubStatusTest.get_status()

        # Check if log_no_workflows was printed
        mock_print.assert_called_with(log_no_workflows) 

    def test_get_status_with_mock_response_Fallo_JSON(self):
        # Create a mock response object
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.side_effect = ValueError("Invalid JSON")


        # Create a mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # Monkey patch urequests.get with the mock function
        import Services.GithubStatusTest
        Services.GithubStatusTest.urequests.get = mock_get


        # Capture print statements using a context manager
        with patch('builtins.print') as mock_print:
            # Call the get_status function
            Services.GithubStatusTest.get_status()

        # Check if log_no_workflows was printed
        mock_print.assert_called_with(log_fallo_json) 

    def test_get_status_with_mock_response_Fallo_Request(self):
        # Create a mock response object
        mock_response = MagicMock()
        mock_response.status_code = 404


        # Create a mock urequests.get function
        mock_get = MagicMock(return_value=mock_response)

        # Monkey patch urequests.get with the mock function
        import Services.GithubStatusTest
        Services.GithubStatusTest.urequests.get = mock_get


        # Capture print statements using a context manager
        with patch('builtins.print') as mock_print:
            # Call the get_status function
            Services.GithubStatusTest.get_status()

        # Check if log_no_workflows was printed
        mock_print.assert_called_with(f"{log_fallo_request_datos} 404") 

if __name__ == '__main__':
    unittest.main()
