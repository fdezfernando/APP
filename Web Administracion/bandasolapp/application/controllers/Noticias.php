<?php
defined('BASEPATH') OR exit('No direct script access allowed');

// Clase del controlador de noticias

class Noticias extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
    $this->load->model('noticias_model');
    //$this->ion_auth->logout();
    // Filtración para el login
    if (!$this->ion_auth->logged_in())
    {
      redirect('auth/login');
    }

  }
  // Función index, la que sale por defecto
  public function index() {
    // Guardamos en un array las noticias que nos traemos
    $noticias_array = $this->noticias_model->get_listado_noticias();
    // Creamos un array de datos con el titulo
    $datos = array(
      'title' => "Noticias"
    );
    // Cargamos nuestro header de la vista y sus datos
    $this->load->view('commons/header',$datos);
    //  Pasamos los datos recogidos en un array
    $datos_cuerpo = array(
      'noticias' => $noticias_array
    );
    // cargamos la vista princiapl y sus datos
    $this->load->view('lista_noticias', $datos_cuerpo);
    // cargamos el footer
    $this->load->view('commons/footer');
  }
  // Método que elimina un noticia
  public function delete($id) {
    $this->noticias_model->delete_noticia($id);
    redirect('noticias');
  }
  // Método que devuelve la información que se va a editar
  public function editajax() {
    $idE = $this->input->get("idNoticiaAjax");
    $noticia = $this->noticias_model->get_noticia($idE);
    echo json_encode($noticia);
  }
  // Método que edita una noticia
  public function edit(){
    $this->noticias_model->edit_noticia();
    echo json_encode(array("status" => TRUE));
  }
  // Método que inserta una noticia
  public function insert(){
    $this->noticias_model->insert_noticia();
    echo json_encode(array("status" => TRUE));
  }
}
