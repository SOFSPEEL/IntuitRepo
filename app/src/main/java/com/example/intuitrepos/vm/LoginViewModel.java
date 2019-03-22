package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.intuitrepos.repository.IRepository;
public
class LoginViewModel extends ViewModel {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private IRepository repository;

    public LoginViewModel(IRepository repository) {
        this.repository = repository;

        Creds creds = repository.getCreds();
        username.set(creds.getUsername());
        password.set(creds.getPassword());
    }


    public void saveCreds() {
        repository.saveCreds(username.get(), password.get());
    }
}
