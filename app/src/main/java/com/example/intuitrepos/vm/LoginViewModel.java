package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.intuitrepos.dto.Credentials;
import com.example.intuitrepos.repository.IRepository;
public
class LoginViewModel extends ViewModel {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private IRepository repository;

    public LoginViewModel(IRepository repository) {
        this.repository = repository;

        Credentials credentials = repository.fetchCredentials();
        username.set(credentials.getUsername());
        password.set(credentials.getPassword());
    }


    public void saveCreds() {
        repository.saveCredentials(username.get(), password.get());
    }
}
