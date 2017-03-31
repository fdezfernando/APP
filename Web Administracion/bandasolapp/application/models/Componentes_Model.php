<?php

// Clase modelo del componente

class Componentes_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }

  // Método que devuelve una lista de componentes
  public function get_listado_componentes()
  {
    // SELECT * FROM componente
    $query = $this->db->get('Componente');
    return $query->result();
    /*$this->db->select('*');
    $this->db->from('Componente');
    $this->db->join('instrumento', 'instrumento.idInstrumento=componente.idComponente');
    $query = $this->db->get();
    return $query->result();*/

  }
}
