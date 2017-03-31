<?php
defined('BASEPATH') OR exit('No direct script access allowed');

// Clase del controlador de Instrumentos

class Instrumentos extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
    $this->load->database();
    $this->load->helper('url');
    $this->load->library('grocery_CRUD');

    // Filtración para el login
    if (!$this->ion_auth->logged_in())
    {
      redirect('auth/login');
    }
  }

  // Función index, la que sale por defecto
  public function index()
  {
    try{
      $crud = new grocery_CRUD();
      // Tema CSS que se encuentra en el directorio
      // assets/grocery_crud/themes/... lo cargamos
      // dinámicamente
      $crud->set_theme('bootstrap');
      // Nombre de la tabla en nuestra base de datos
      $crud->set_table('instrumento');
      // Listado de campos obligatorios, de la tabla Instrumentos
      $crud->required_fields('nombreInstrumento');
      // A Continuación, escribo los nombres de los
      // campos de la tabla Instrumentos que quiero que se muestren
      // en la vista que se va a generar.
      $crud->columns('idInstrumento','nombreInstrumento','numeroRegistro');
      //Formateamos el nombre de los campos de la base de datos en bueno
      $crud->display_as('idInstrumento','Id');
      $crud->display_as('nombreInstrumento','Nombre del Instrumento');
      $crud->display_as('numeroRegistro','Nº Registro');
      // Renderizamos nuestro Grocery Crud para que se muestre en la vista
      $output = $crud->render();
      // Creamos un array de datos con el titulo y el archivo css
      $datos_header = array(
        'title' => "Instrumentos", // En la vista 'header' tendré una variable $title
        'css_files' => $output->css_files
      );
      // Cargamos el header con sus datos
      // Cargamos la vista, en este caso Instrumentos
      // Cargamos el footer con sus datos
      $this->load->view("commons/header",$datos_header);
      $this->load->view("instrumentos",(array)$output);
      $this->load->view("commons/footer",(array)$output);
      // Controlamos la excepción por si falla
    }catch(Exception $e){
      show_error($e->getMessage().' --- '.$e->getTraceAsString());
    }
  }
}
