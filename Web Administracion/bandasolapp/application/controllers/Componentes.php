<?php
defined('BASEPATH') OR exit('No direct script access allowed');

// Clase del controlador Componentes

class Componentes extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
    $this->load->database();
    $this->load->helper('url');
    $this->load->library('grocery_CRUD');

    // Filtración para el login
    if (!$this->ion_auth->logged_in())
    {
      redirect('auth/login'); // Redirigimos al login
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
      $crud->set_table('componente');
      // Listado de campos obligatorios, de la tabla Componentes
      $crud->required_fields('nombre');
      // Relacion de uno a uno
      $crud->set_relation('Instrumento_idInstrumento','instrumento','{nombreInstrumento} - {numeroRegistro}');
      // A Continuación, escribo los nombres de los
      // campos de la tabla Componente que quiero que se muestren
      // en la vista que se va a generar.
      $crud->columns('idComponente','nombre','apellidos','mote','Instrumento_idInstrumento','email','movil','profesion');
      //Formateamos el nombre de los campos de la base de datos en bueno
      $crud->display_as('idComponente','Id');
      $crud->display_as('anteriorFormacion','Anterior Formación');
      $crud->display_as('cP','Código Postal');
      $crud->display_as('direccion','Dirección');
      $crud->display_as('fechaBaja','Fecha de Baja');
      $crud->display_as('fechaIngreso','Fecha de Ingreso');
      $crud->display_as('fechaNacimiento','Fecha de Nacimiento');
      $crud->display_as('movil','Móvil');
      $crud->display_as('nif','NIF');
      $crud->display_as('profesion','Profesión');
      $crud->display_as('telefonoFijo','Telefono Fijo');
      $crud->display_as('Instrumento_idInstrumento','Instrumento');
      // Renderizamos nuestro Grocery Crud para que se muestre en la vista
      $output = $crud->render();
      // Creamos un array de datos con el titulo y el archivo css
      $datos_header = array(
        'title' => "Componentes", // En la vista 'header' tendré una variable $title
        'css_files' => $output->css_files
      );
      // Cargamos el header con sus datos
      // Cargamos la vista, en este caso Componentes
      // Cargamos el footer con sus datos
      $this->load->view("commons/header",$datos_header);
      $this->load->view("componentes",(array)$output);
      $this->load->view("commons/footer",(array)$output);

      // Controlamos la excepción por si falla
    }catch(Exception $e){
      show_error($e->getMessage().' --- '.$e->getTraceAsString());
    }
  }


}
