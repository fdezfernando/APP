<?php

// Clase modelo marchas

class Marchas_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }
  
  // Método que devuelve un listado de marchas
  public function get_listado_marchas()
  {
    // SELECT * FROM marcha
    $query = $this->db->get('Marcha');
    return $query->result();
  }



}
