<?php
defined('BASEPATH') OR exit('No direct script access allowed');

// Clase del controlador marchas

class Marchas extends CI_Controller {

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
      $crud->set_table('marcha');
      // Listado de campos obligatorios, de la tabla marchas
      $crud->required_fields('nombreMarcha');
      $crud->set_relation('Componente_idComponente','componente','nombre');
      // A Continuación, escribo los nombres de los
      // campos de la tabla marchas que quiero que se muestren
      // en la vista que se va a generar.
      $crud->columns('idMarcha','nombreMarcha','autor','Componente_idComponente');
      //Formateamos el nombre de los campos de la base de datos en bueno
      $crud->display_as('idMarcha','Id');
      $crud->display_as('nombreMarcha','Nombre de la Marcha');
      $crud->display_as('Componente_idComponente','Solista');
      // Renderizamos nuestro Grocery Crud para que se muestre en la vista
      $output = $crud->render();
      // Creamos un array de datos con el titulo y el archivo css
      $datos_header = array(
        'title' => "Marchas", // En la vista 'header' tendré una variable $title
        'css_files' => $output->css_files
      );
      // Cargamos el header con sus datos
      // Cargamos la vista, en este caso Marchas
      // Cargamos el footer con sus datos
      $this->load->view("commons/header",$datos_header);
      $this->load->view("marchas",(array)$output);
      $this->load->view("commons/footer",(array)$output);
      // Controlamos la excepción por si falla
    }catch(Exception $e){
      show_error($e->getMessage().' --- '.$e->getTraceAsString());
    }
  }


}
