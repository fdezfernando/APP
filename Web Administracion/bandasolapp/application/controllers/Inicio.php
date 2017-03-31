<?php
defined('BASEPATH') OR exit('No direct script access allowed');

//Clase del controlador de Inicio

class Inicio extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
    $this->load->model('inicio_model');
    // Si no eres administrador no puedes entrar, filtración
    if (!$this->ion_auth->is_admin()){
      $mensaje = $this->session->set_flashdata('message', 'Tienes que ser Administrador para tener acceso');
      redirect('auth/login');
      echo $mensaje;
    }
    // Filtración para el login, hay que loguearse antes de accerder
    if (!$this->ion_auth->logged_in()){
      redirect('auth/login');
    }
  }
  // Función index, la que sale por defecto
  public function index()
  {
    // Guardamos en 4 varianles el número de componentes, conciertos,
    // instrumentos y marchas
    $num_componentes = $this->inicio_model->get_count_componentes();
    $num_conciertos = $this->inicio_model->get_count_conciertos();
    $num_instrumentos = $this->inicio_model->get_count_instrumentos();
    $num_marchas = $this->inicio_model->get_count_marchas();

    // Creamos un array de datos con el titulo
    $datos = array(
      'title' => "Inicio"
    );
    // Cargamos nuestro header
    $this->load->view('commons/header',$datos);
    // Creamos un array con nuestra 4 variables para pasarle
    // los datos.
    $datos_cuerpo = array(
      'num_componentes' => $num_componentes,
      'num_conciertos' => $num_conciertos,
      'num_instrumentos' => $num_instrumentos,
      'num_marchas' => $num_marchas
    );
    // Cargamos la vista y los datos a ella.
    $this->load->view('inicio', $datos_cuerpo);
    // Cargamos nuestro footer
    $this->load->view('commons/footer');
  }
}
