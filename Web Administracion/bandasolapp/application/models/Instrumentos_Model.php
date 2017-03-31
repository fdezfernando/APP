<?php

// Clase model de instrumentos

class Instrumentos_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }

  // Método que devuelve un listado de instrumentos
  public function get_listado_instrumentos()
  {
    // SELECT * FROM instrumento
    $query = $this->db->get('Instrumento');
    return $query->result();
  }
}
