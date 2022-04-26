import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-usersmanager',
  templateUrl: './usersmanager.component.html',
  styleUrls: ['./usersmanager.component.css']
})
export class UsersmanagerComponent implements OnInit {


  myArray: any[] = [];
  newUser: any = {
    id: '',
    firstname: '',
    lastname: '',
    email: '',
    role: ''

  };
  myCondition: Boolean = false;

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getAll().subscribe(data => { this.myArray = data; })

  }

  deleteUser(id: number) {

    this.userService.delete(id).subscribe(
      () => {
        this.myArray = this.myArray.filter
          (userIterator => userIterator.id != id)
      })
  }

  addUser() {
    this.userService.post(this.newUser).subscribe
      ((userIterator) => {
        this.myArray = [userIterator, ...this.myArray];
        this.emptyInput();
      })
  }

  emptyInput() {
    this.newUser = {
      id: '',
      firstname: '',
      lastname: '',
      email: '',
      role: ''
    }
  }

  editUser(userIterator: any) {
    this.newUser = userIterator;
    this.myCondition = true;
  }

  updateUser() {
    this.userService.update(this.newUser).subscribe
      (users => {
        this.emptyInput();
        this.myCondition = false;
      })
  }

  //searchName(): void {
    //this.currentUsersmanager = {};
   // this.currentIndex = -1;
   // this.userService.findByTitle(this.lastName)
    //  .subscribe({
      //  next: (data) => {
        //  this.Usersmanager = data;
         // console.log(data);
       // },
      //  error: (e) => console.error(e)
     // });
  //}
}
