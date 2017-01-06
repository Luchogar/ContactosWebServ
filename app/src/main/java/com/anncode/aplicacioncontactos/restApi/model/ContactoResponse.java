package com.anncode.aplicacioncontactos.restApi.model;

import com.anncode.aplicacioncontactos.model.Contacto;

import java.util.ArrayList;

/**
 * Created by Luis García on 05/01/2017.
 */

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
