import { Component, OnInit } from '@angular/core';
import { Ipo } from '../models/ipo';
import { IpoService } from '../service/ipo.service';

@Component({
  selector: 'app-viewipos',
  templateUrl: './viewipos.component.html',
  styleUrls: ['./viewipos.component.css']
})
export class ViewiposComponent implements OnInit {
  constructor(private ipoService :IpoService) {}
  ipos:Ipo[];
 
  ngOnInit()
   {
    this.ipoService.getAllIpos().subscribe(data=>
      {
      this.ipos=data;
      })
  }

}
