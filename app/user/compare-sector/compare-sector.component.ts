import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-compare-sector',
  templateUrl: './compare-sector.component.html',
  styleUrls: ['./compare-sector.component.css']
})
export class CompareSectorComponent implements OnInit {
  sector:FormGroup;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.sector=this.formBuilder.group({
      comapny_sector:['',[Validators.required]],
      se:['',[Validators.required]],
      cname_sname:['',Validators.required],
      fdate:['',Validators.required],
      tdate:['',Validators.required]
    });
  }
  onSubmit()
  {
    console.log(this.sector.value);
  }
}
