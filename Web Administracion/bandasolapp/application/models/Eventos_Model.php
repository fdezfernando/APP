<?php

// Clase modelo eventos

class Eventos_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }

  // Método que devuelve una lista de eventos
  public function get_listado_eventos()
  {
    // SELECT * FROM evento
    $query = $this->db->get('Evento');
    return $query->result();

    /*$this->db->select('*');
    $this->db->from('componente');
    $this->db->join('componente_evento', 'componente_evento.idComponente=evento.idEvento');
    $query = $this->db->get();
    return $query->result();*/

  }



}
