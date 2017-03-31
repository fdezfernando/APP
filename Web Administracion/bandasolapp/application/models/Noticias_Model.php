<?php

// Clase modelo noticias

class Noticias_Model extends CI_Model {

  public function __construct()
  {
    parent::__construct();
    // Your own constructor code
    $this->load->database();
  }

  // Método que devuelve una lista de noticias
  public function get_listado_noticias() {
    // SELECT * FROM Noticias
    $query = $this->db->get('Noticia');
    return $query->result();
  }

  // Método que devuelve una noticia
  public function get_noticia($idNoticia){
    $this->db->where('idNoticia',$idNoticia);
    $query = $this->db->get('Noticia');
    return $query->row();

  }

  // Método que elimina una noticia
  public function delete_noticia($id) {
    $this->db->where('idNoticia', $id);
    $this->db->delete('noticia');
  }

  // Método que añade una noticia
  public function insert_noticia(){

    $datos = array(
      'titulo' => $this->input->post('tituloAjax'),
      'cuerpo' => $this->input->post('cuerpoAjax'),
      'fecha' =>  date("Y/m/d")
    );

    $this->db->set($datos);
    $this->db->insert('Noticia');

  }

  //Método que edita una noticia
  public function edit_noticia(){
    $datos = array(
      'titulo' => $this->input->post('tituloAjaxEdit'),
      'cuerpo' => $this->input->post('cuerpoAjaxEdit'),
      'fecha'  => date("Y/m/d")
    );

    $id = $this->input->post('idEdicion');
    $this->db->set($datos);
    $this->db->where('idNoticia', $id);
    $this->db->update('Noticia', $datos);
  }

}
