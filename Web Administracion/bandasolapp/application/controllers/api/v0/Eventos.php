<?php
// Clase Eventos de la API
defined('BASEPATH') OR exit('No direct script access allowed');

// This can be removed if you use __autoload() in config.php OR use Modular Extensions
/** @noinspection PhpIncludeInspection */
require APPPATH . '/libraries/REST_Controller.php';

// use namespace
use Restserver\Libraries\REST_Controller;

/**
* This is an example of a few basic user interaction methods you could use
* all done with a hardcoded array
*
* @package         CodeIgniter
* @subpackage      Rest Server
* @category        Controller
* @author          Phil Sturgeon, Chris Kacerguis
* @license         MIT
* @link            https://github.com/chriskacerguis/codeigniter-restserver
*/
class Eventos extends REST_Controller {

  // Método que devuelve una lista de eventos
  public function lista_eventos_get()
  {
    // Cargo el modelo eventos
    $this->load->model('eventos_model');
    // Guardo en un array el listado de eventos llamado
    // desde el método del modelo
    $eventos_array = $this->eventos_model->get_listado_eventos();

    // La siguiente línea de código devuelvo en formato
    // JSON el listado de eventos de la base de datos_cuerpo
    // dando como código de respuesta 200
    $this->set_response($eventos_array, REST_Controller::HTTP_OK);
  }
}
