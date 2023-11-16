import unittest
from unittest import TestCase
from unittest.mock import MagicMock, patch
from Services.GithubStatus import get_status, MockOutputManager
from Configuration.Constants import log_build_exitoso, log_build_fallido, log_no_workflows, log_fallo_json, log_fallo_request_datos

class TestGithubApi(TestCase):

    def test_get_status_con_mock_response_Build_exitoso(self):
        
        # Crear una instancia de la clase MockUrequests y asignarla a la variable mock_get
        mock_get = MagicMock(return_value=None)
        # Configurar el comportamiento de MockUrequests.get para devolver una respuesta simulada
        mock_get.get.return_value.status_code = 200  # Configurar el código de estado
        mock_get.get.return_value.json.return_value = {
            "workflow_runs": [
                {"conclusion": "success"}
            ]
        }

        # Crear una instancia de MockOutputManager
        mock_output_manager = MockOutputManager()

        # patch urequests.get con mock_get y MockOutputManager.waiting_status con la instancia creada
        with patch('Services.GithubStatus.urequests', mock_get), \
             patch('Services.GithubStatus.MockOutputManager', MagicMock(return_value=mock_output_manager)):
            # Capturar print
            with patch('builtins.print') as mock_print:
                # Llamar get_status con el argumento tiempo
                get_status(2)

            # Verificar log_build_exitoso
            mock_print.assert_called_with(log_build_exitoso)

    def test_get_status_con_mock_response_Build_fallido(self):
        
        # Crear una instancia de la clase MockUrequests y asignarla a la variable mock_get
        mock_get = MagicMock(return_value=None)
        # Configurar el comportamiento de MockUrequests.get para devolver una respuesta simulada
        mock_get.get.return_value.status_code = 200  # Configurar el código de estado
        mock_get.get.return_value.json.return_value = {
            "workflow_runs": [
                {"conclusion": "failure"}
            ]
        }

        # Crear una instancia de MockOutputManager
        mock_output_manager = MockOutputManager()

        # patch urequests.get con mock_get y MockOutputManager.waiting_status con la instancia creada
        with patch('Services.GithubStatus.urequests', mock_get), \
             patch('Services.GithubStatus.MockOutputManager', MagicMock(return_value=mock_output_manager)):
            # Capturar print
            with patch('builtins.print') as mock_print:
                # Llamar get_status con el argumento tiempo
                get_status(2)

            # Verificar log_build_fallido
            mock_print.assert_called_with(log_build_fallido)    

    def test_get_status_con_mock_response_No_Workflows(self):
        
        # Crear una instancia de la clase MockUrequests y asignarla a la variable mock_get
        mock_get = MagicMock(return_value=None)
        # Configurar el comportamiento de MockUrequests.get para devolver una respuesta simulada
        mock_get.get.return_value.status_code = 200  # Configurar el código de estado
        mock_get.get.return_value.json.return_value = {
            "workflow_runs": [
                
            ]
        }

        # Crear una instancia de MockOutputManager
        mock_output_manager = MockOutputManager()

        # patch urequests.get con mock_get y MockOutputManager.waiting_status con la instancia creada
        with patch('Services.GithubStatus.urequests', mock_get), \
             patch('Services.GithubStatus.MockOutputManager', MagicMock(return_value=mock_output_manager)):
            # Capturar print
            with patch('builtins.print') as mock_print:
                # Llamar get_status con el argumento tiempo
                get_status(2)

            # Verificar log_no_workflows
            mock_print.assert_called_with(log_no_workflows)

    def test_get_status_con_mock_response_Fallo_JSON(self):
        
        # Crear una instancia de la clase MockUrequests y asignarla a la variable mock_get
        mock_get = MagicMock(return_value=None)
        # Configurar el comportamiento de MockUrequests.get para devolver una respuesta simulada
        mock_get.get.return_value.status_code = 200  # Configurar el código de estado
        mock_get.get.return_value.json.side_effect = ValueError("Invalid JSON")

        # Crear una instancia de MockOutputManager
        mock_output_manager = MockOutputManager()

        # patch urequests.get con mock_get y MockOutputManager.waiting_status con la instancia creada
        with patch('Services.GithubStatus.urequests', mock_get), \
             patch('Services.GithubStatus.MockOutputManager', MagicMock(return_value=mock_output_manager)):
            # Capturar print
            with patch('builtins.print') as mock_print:
                # Llamar get_status con el argumento tiempo
                get_status(2)

            # Verificar log_fallo_json
            mock_print.assert_called_with(log_fallo_json)

    def test_get_status_con_mock_response_Fallo_Request(self):
        
        # Crear una instancia de la clase MockUrequests y asignarla a la variable mock_get
        mock_get = MagicMock(return_value=None)
        # Configurar el comportamiento de MockUrequests.get para devolver una respuesta simulada
        mock_get.get.return_value.status_code = 404  # Configurar el código de estado


        # Crear una instancia de MockOutputManager
        mock_output_manager = MockOutputManager()

        # patch urequests.get con mock_get y MockOutputManager.waiting_status con la instancia creada
        with patch('Services.GithubStatus.urequests', mock_get), \
             patch('Services.GithubStatus.MockOutputManager', MagicMock(return_value=mock_output_manager)):
            # Capturar print
            with patch('builtins.print') as mock_print:
                # Llamar get_status con el argumento tiempo
                get_status(2)

            # Verificar log_fallo_request_datos
            mock_print.assert_called_with(f"{log_fallo_request_datos} 404")

if __name__ == '__main__':
    unittest.main()
