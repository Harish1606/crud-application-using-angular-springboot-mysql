import { CrudService } from './../crud.service';
import { User } from './../User';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  user=new User();
  constructor(private service:CrudService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.addUser(this.user).subscribe(data=>{
      console.log(data);
    },
    error=>{
      console.log(error);
    })
  }

}
