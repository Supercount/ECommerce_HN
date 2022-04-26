import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signupForm !: FormGroup;
  title = 'formvalidation';
  submitted = false;
  constructor(private formBuilder: FormBuilder, private hhtp: HttpClient, private router: Router) { }


  ngOnInit(): void {
    this.signupForm = this.formBuilder.group(
      {
        lastname: ['', [Validators.required, Validators.minLength(2)]],
        firstname: ['', [Validators.required, Validators.minLength(2)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        role: ['User'],
      })
  }

  onSubmit() {
    this.submitted = true;

    if (this.signupForm.invalid) {
      return;
    }
  }

  signUp() {

    this.submitted = true;
    if (this.signupForm.invalid) {
      return;
    }
    this.hhtp.post<any>("http://localhost:3000/users", this.signupForm.value)
      .subscribe(res => {
        alert("Merci pour votre inscription!");
        this.signupForm.reset();
        this.router.navigate(['login'])
      }
      );
  }



  get f() {

    return this.signupForm.controls;
  }


  //convenience getter for easy access to form fields
  get f1(): { [key: string]: AbstractControl; } {
    return this.signupForm.controls;
  }

}
