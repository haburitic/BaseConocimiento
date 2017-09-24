import { Component } from '@angular/core';
import { FormGroup, AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.html',
  styleUrls: ['./login.scss']

})
export class Login {

  private form: FormGroup;
  private email: AbstractControl;
  private password: AbstractControl;
  private submitted: boolean = false;
  //private location;
  constructor(fb: FormBuilder, private router: Router) {
    this.form = fb.group({ 
      'email': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
    });

    this.email = this.form.controls['email'];
    this.password = this.form.controls['password'];
  }

  private onSubmit(values: Object): void {
    this.submitted = true;

    if (this.form.valid) {
      // your code goes here

      if (this.email.value === "admin@admin.co" && this.password.value === "123456") {
        console.log(this.email, this.password);
        window.location.replace('#/pages/dashboard');
      } else {

        alert('Error, ingrese nuevamente sus datos');
      }
    }


  }
}

