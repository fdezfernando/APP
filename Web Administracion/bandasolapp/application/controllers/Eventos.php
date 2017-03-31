<?php
defined('BASEPATH') OR exit('No direct script access allowed');

// Clase del controlador de Eventos

class Eventos extends CI_Controller {

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
      $crud->set_table('evento');
      $crud->set_relation_n_n('musicoeventos', 'componente_evento', 'componente', 'idEvento', 'idComponente', 'nombre');
      // Listado de campos obligatorios, de la tabla Eventos
      $crud->fields('nombreEvento', 'lugar', 'fecha', 'musicoeventos');
      // A Continuación, escribo los nombres de los
      // campos de la tabla Evento que quiero que se muestren
      // en la vista que se va a generar.
      $crud->columns('idEvento','nombreEvento','lugar','fecha','musicoeventos');

      //Formateamos el nombre de los campos de la base de datos en bueno
      $crud->display_as('idEvento','Id');
      $crud->display_as('nombreEvento','Nombre del Evento');
      $crud->display_as('musicoeventos','Faltan al Evento');
      // Renderizamos nuestro Grocery Crud para que se muestre en la vista
      $crud->unset_bootstrap();
      $output = $crud->render();
      // Creamos un array de datos con el titulo y el archivo css
      $datos_header = array(
        'title' => "Eventos", // En la vista 'header' tendré una variable $title
        'css_files' => $output->css_files
      );
      // Cargamos el header con sus datos
      // Cargamos la vista, en este caso Eventos
      // Cargamos el footer con sus datos
      $this->load->view("commons/header",$datos_header);
      $this->load->view("eventos",(array)$output);
      $this->load->view("commons/footer",(array)$output);
      // Controlamos la excepción por si falla
    }catch(Exception $e){
      show_error($e->getMessage().' --- '.$e->getTraceAsString());
    }
  }
}
