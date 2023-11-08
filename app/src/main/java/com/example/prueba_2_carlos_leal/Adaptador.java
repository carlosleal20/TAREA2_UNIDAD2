package com.example.prueba_2_carlos_leal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter{
    ArrayList<Contacto> lista;
    daoContacto dao;
    Contacto c;
    Activity a;
    int id=0;
    public Adaptador(Activity a, ArrayList<Contacto> lista, daoContacto dao ){
        this.lista = lista;
        this.a= a;
        this.dao= dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        c=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c=lista.get(i);
        return c.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {

        View v = view;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.activity_item, null);
        }

        c=lista.get(posicion);

        TextView nombre=v.findViewById(R.id.nombre);
        TextView apellido=v.findViewById(R.id.apellido);
        TextView email=v.findViewById(R.id.email);
        TextView telefono=v.findViewById(R.id.telefono);
        TextView ciudad=v.findViewById(R.id.ciudad);
        TextView rut=v.findViewById(R.id.rut);
        TextView producto=v.findViewById(R.id.producto);
        TextView total=v.findViewById(R.id.total);
        Button editar= v.findViewById(R.id.btn_editar);
        Button eliminar= v.findViewById(R.id.btn_eliminar);
        nombre.setText(c.getNombre());
        apellido.setText(c.getApellido());
        email.setText(c.getEmail());
        telefono.setText(c.getTelefono());
        ciudad.setText(c.getCiudad());
        rut.setText(c.getRut());
        total.setText(c.getTotal());
        producto.setText(c.getProducto());
        editar.setTag(posicion);
        eliminar.setTag(posicion);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialogo de editar
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog dialog = new Dialog(a);
                dialog.setTitle("Editar Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.activity_dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.et_nombre);
                final EditText apellido = dialog.findViewById(R.id.et_apellido);
                final EditText email = dialog.findViewById(R.id.et_email);
                final EditText telefono = dialog.findViewById(R.id.et_telefono);
                final EditText ciudad = dialog.findViewById(R.id.et_ciudad);
                final EditText rut = dialog.findViewById(R.id.et_rut);
                final EditText total = dialog.findViewById(R.id.et_total);
                final EditText producto = dialog.findViewById(R.id.producto);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                c=lista.get(pos);
                setId(c.getId());
                nombre.setText(c.getNombre());
                apellido.setText(c.getApellido());
                email.setText(c.getEmail());
                telefono.setText(c.getTelefono());
                ciudad.setText(c.getCiudad());
                rut.setText(c.getRut());
                total.setText(c.getTotal());
                producto.setText(c.getProducto());
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            c = new Contacto(getId(), nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    email.getText().toString(),
                                    telefono.getText().toString(),
                                    rut.getText().toString(),
                                    producto. getText(),toString(),
                                    total.getText().toString(),
                                    ciudad.getText().toString());
                            dao.editar(c);
                            lista=dao.verTodo();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(a, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialogo para confirmar si o no se elimine
                int pos=Integer.parseInt(view.getTag().toString());
                c=lista.get(posicion);
                setId(c.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("Estas seguro de eliminar");
                del.setCancelable(false);
                del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.eliminar(getId());
                        lista=dao.verTodo();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                del.show();
            }
        });
        return v;
    }
}