import { User } from './../User';
import { CrudService } from './../crud.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users:User[]=[];
  constructor(private service:CrudService,private router:Router) { }

  ngOnInit(): void {
    this.service.getAllUsers().subscribe(data=>{
      this.users=data;
    },
    error=>{
      console.log(error);
    })
  }

  update(id:number){
    this.router.navigate(['/update/'+id]);
  }

  deleteUser(id:number){
    this.service.deleteUser(id).subscribe(data=>{
      console.log(data);
    },
    error=>{
      console.log(error);
    })
  }

}
