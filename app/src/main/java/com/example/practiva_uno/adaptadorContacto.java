package com.example.practiva_uno;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptadorContacto extends RecyclerView.Adapter<adaptadorContacto.contactoViewHolder> {

    List<contacto> mList;
    Context mContext;
    MainActivity MainActivity;

    public adaptadorContacto(List<contacto> mList, Context mContext, MainActivity MainActivity) {
        this.mList = mList;
        this.mContext = mContext;
        this.MainActivity = MainActivity;
    }

    @NonNull
    @Override
    public contactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lista_contatos, parent, false);
        return new contactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorContacto.contactoViewHolder holder, int position) {
        holder.setContacto(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class contactoViewHolder extends RecyclerView.ViewHolder {
        EditText nombre, numero;
        Button bt_llamar, bt_mensaje;

        public contactoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.id_nombre);
            numero = itemView.findViewById(R.id.id_numero);
            bt_llamar = itemView.findViewById(R.id.bt_llamar);
            bt_mensaje = itemView.findViewById(R.id.bt_mensaje);
        }


        public void setContacto(contacto contacto) {
            nombre.setText(contacto.getNombre());
            numero.setText(contacto.getNumero());


            bt_llamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!verificarPermisoLlamar()) {
                        String phone = "+51" + contacto.getNumero();
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
                        mContext.startActivity(intent);
                    } else {
                        ActivityCompat.requestPermissions(MainActivity, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                }
            });

            bt_mensaje.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!PermisoSMS()) {
                        String message = "Hola soy nataly, ";
                        String phoneNo = contacto.getNumero();
                        if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {

                            Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                            smsIntent.setType("vnd.android-dir/mms-sms");
                            smsIntent.putExtra("address", phoneNo);
                            smsIntent.putExtra("sms_body", "Hola soy nataly, ");
                            smsIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(smsIntent);
                        }
                    } else {
                        ActivityCompat.requestPermissions(MainActivity, new String[]{Manifest.permission.SEND_SMS}, 2);
                    }
                }
            });
        }

        private boolean verificarPermisoLlamar() {
            return ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED;
        }

        private boolean PermisoSMS() {
            return ActivityCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED;
        }
    }
}
