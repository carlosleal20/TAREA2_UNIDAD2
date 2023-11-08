package com.example.prueba_2_carlos_leal;

import android.text.Editable;

public class Contacto {

    int id;
    String nombre;
    String apellido;
    String email;
    String telefono;
    String ciudad;
    String rut;
    String producto;
    String total;

    public Contacto() {

    }

    public Contacto(String nombre, String apellido, String email, String telefono, String ciudad, String rut, String producto, String total) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.rut= rut;
        this.producto = producto;
        this.total= total;
    }

    public Contacto(int id, String nombre, String apellido, String email, String telefono, String ciudad, String rut, String producto, String total) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.rut= rut;
        this.producto= producto;
        this.total = total;
    }

    public Contacto(int id, String toString, String toString1, String toString2, String toString3, String toString4, Editable text, String toString5, String toString6, String toString7) {
    }

    public Contacto(int anInt, String string, String string1, String string2, String string3, String string4) {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}