<?php

// Clase modelo de inicio

class Inicio_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    $this->load->database();
  }

  // Método que devuelve la cantidad de componentes
  public function get_count_componentes() {
    $query = $this->db->query('SELECT * FROM componente');
    return $query->num_rows();
  }

  // Método que devuelve la cantidad de conciertos
  public function get_count_conciertos() {
    $query = $this->db->query('SELECT * FROM evento');
    return $query->num_rows();
  }

  // Método que devuelve la cantidad de instrumentos
  public function get_count_instrumentos() {
    $query = $this->db->query('SELECT * FROM instrumento');
    return $query->num_rows();
  }

  // Método que devuelve la cantidad de marchas
  public function get_count_marchas() {
    $query = $this->db->query('SELECT * FROM marcha');
    return $query->num_rows();
  }
}
