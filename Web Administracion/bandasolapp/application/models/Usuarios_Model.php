<?php

// Clase modelo usuario

class Usuarios_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }

  // Método que devuelve una lista de usuario
  public function get_user_by_email($email)
  {
    // SELECT * FROM users WHERE email='$email'
    $this->db->where('email',$email);
    $query = $this->db->get('users');
    return $query->row();
  }
}
