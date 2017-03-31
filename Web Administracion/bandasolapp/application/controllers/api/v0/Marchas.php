<?php

// Clase Marchas de la API

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
class Marchas extends REST_Controller {

  // Método que devuelve una lista de marchasss
  public function lista_marchas_get()
  {
    // Cargo el modelo marchas
    $this->load->model('marchas_model');
    // Guardo en un array el listado de marchas llamado
    // desde el método del modelo
    $marchas_array = $this->marchas_model->get_listado_marchas();

    // La siguiente línea de código devuelvo en formato
    // JSON el listado de marchas de la base de datos_cuerpo
    // dando como código de respuesta 200
    $this->set_response($marchas_array, REST_Controller::HTTP_OK);
  }

}
