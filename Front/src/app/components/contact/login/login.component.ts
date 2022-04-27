import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private formBuilder: FormBuilder, private signinService: UsersService, private router: Router) { }

  signinForm: FormGroup = this.formBuilder.group(
    {
      username: ['', [Validators.required, Validators.minLength(4)]],
      password: ['', [Validators.required, Validators.minLength(8)]],

    })

  onSubmit() {

    if (this.signinForm.invalid) {
      return;
    }

    let user: User =
    {
      id: 0,
      username: this.signinForm.value.username,
      lastName: '',
      firstName: '',
      email: '',
      password: this.signinForm.value.password,
      roleList: []
    }
    this.signin(user);
  }

  signin(user: User) {

    this.signinService.signin(user).subscribe(res => {
      alert("Merci pour votre inscription!");
      this.signinForm.reset();
      this.router.navigate([''])
    }
    );
  }

}
