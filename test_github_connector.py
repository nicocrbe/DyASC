import requests
import random
import time
import unittest
from unittest.mock import MagicMock

GITHUB_URL = "https://github.com"


def make_github_request():
    response = requests.get(GITHUB_URL)
    return response


def make_github_request_with_random_delay():
    random_interval = int(random.randint(1, 5))
    print(random_interval)
    time.sleep(random_interval)
    return make_github_request()


class TestGitHubConnector(unittest.TestCase):

    def test_make_github_request(self):
        # Stub para simular una respuesta de GitHub
        response_stub = MagicMock()
        response_stub.status_code = 200
        response_stub.text = "Contenido de GitHub"

        # Mockear la función de requests.get
        with unittest.mock.patch('requests.get') as mock_get:
            mock_get.return_value = response_stub

            response = make_github_request()

            self.assertEqual(response.status_code, 200)
            self.assertEqual(response.text, "Contenido de GitHub")

    def test_make_github_request_with_random_delay(self):
        # Stub para simular una respuesta de GitHub
        response_stub = MagicMock()
        response_stub.status_code = 200
        response_stub.text = "Contenido de GitHub"

        # Mockear la función de requests.get y time.sleep
        with unittest.mock.patch('requests.get') as mock_get, \
                unittest.mock.patch('time.sleep') as mock_sleep:
            mock_get.return_value = response_stub

            response = make_github_request_with_random_delay()

            self.assertEqual(response.status_code, 200)
            self.assertEqual(response.text, "Contenido de GitHub")

    def test_multiple_github_requests_with_random_delay(self):
        # Stub para simular una respuesta de GitHub
        response_stub = MagicMock()
        response_stub.status_code = 200
        response_stub.text = "Contenido de GitHub"

        # Mockear la función de requests.get y time.sleep
        with unittest.mock.patch('requests.get') as mock_get, \
                unittest.mock.patch('time.sleep') as mock_sleep:
            mock_get.return_value = response_stub

            # Realizar tres solicitudes con intervalos aleatorios
            responses = []
            for _ in range(3):
                responses.append(make_github_request_with_random_delay())

            # Verificar que las solicitudes se realizaron en tiempos distintos
            time_intervals = [mock_sleep.call_args_list[i][0][0] for i in range(3)]
            self.assertTrue((time_intervals[0] != time_intervals[1]) or (time_intervals[0] != time_intervals[2]) or (
                        time_intervals[1] != time_intervals[2]))  # Verifico que los 3 tiempos no sean iguales

    def test_random_delays_within_range_sin_mock(self):
        # Realizar tres solicitudes con intervalos aleatorios
        for _ in range(3):
            start_time = time.time()
            make_github_request_with_random_delay()
            end_time = time.time()

            # Verificar que el tiempo de espera está entre 1 y 5 segundos
            total_time = int(end_time - start_time)
            self.assertGreaterEqual(total_time, 1)
            self.assertLessEqual(total_time, 5)

    def test_random_delays_within_range_con_mock(self):
        # Stub para simular una respuesta de GitHub
        response_stub = MagicMock()
        response_stub.status_code = 200
        response_stub.text = "Contenido de GitHub"

        # Mockear la función de requests.get y time.sleep
        with unittest.mock.patch('requests.get') as mock_get, \
                unittest.mock.patch('time.sleep') as mock_sleep:
            mock_get.return_value = response_stub

            # Realizar tres solicitudes con intervalos aleatorios
            responses = []
            for _ in range(3):
                responses.append(make_github_request_with_random_delay())

            # Verificar que las solicitudes se realizaron en tiempos distintos
            time_intervals = [mock_sleep.call_args_list[i][0][0] for i in range(3)]

            # Verificar que el tiempo de espera está entre 1 y 5 segundos
            self.assertGreaterEqual(time_intervals[0], 1)
            self.assertLessEqual(time_intervals[0], 5)
            self.assertGreaterEqual(time_intervals[1], 1)
            self.assertLessEqual(time_intervals[1], 5)
            self.assertGreaterEqual(time_intervals[2], 1)
            self.assertLessEqual(time_intervals[2], 5)


if __name__ == '__main__':
    unittest.main()
