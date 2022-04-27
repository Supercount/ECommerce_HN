import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = 'formvalidation';
  submitted = false;
  constructor(private formBuilder: FormBuilder, private signupService: UsersService, private router: Router) { }

  signupForm: FormGroup = this.formBuilder.group(
    {
      username: ['', [Validators.required, Validators.minLength(4)]],
      lastname: ['', [Validators.required, Validators.minLength(2)]],
      firstname: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      role: ['User'],
    })



  onSubmit() {
    this.submitted = true;

    if (this.signupForm.invalid) {
      return;
    }

    let user: User =
    {
      id: 0,
      username: this.signupForm.value.username,
      lastName: this.signupForm.value.lastname,
      firstName: this.signupForm.value.firstname,
      email: this.signupForm.value.email,
      password: this.signupForm.value.password,
      roleList: this.signupForm.value.role
    }
    this.signUp(user);
  }

  signUp(user: User) {

    this.signupService.signup(user).subscribe(res => {
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
