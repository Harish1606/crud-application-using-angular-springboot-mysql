import { User } from './../User';
import { CrudService } from './../crud.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  user=new User();
  id:any;
  constructor(private service:CrudService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');
    this.service.getUser(this.id).subscribe(data=>{
      this.user=data;
    },
    error=>{
      console.log(error);
    })
  }

  onSubmit(){
    this.service.updateUser(this.id,this.user).subscribe(data=>{
      console.log(data);
    },
    error=>{
      console.log(error);
    })
  }

}
