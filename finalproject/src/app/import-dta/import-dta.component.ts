import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UploadService } from '../service/upload.service';

@Component({
  selector: 'app-import-dta',
  templateUrl: './import-dta.component.html',
  styleUrls: ['./import-dta.component.css']
})
export class ImportDtaComponent implements OnInit
 {
   excelUploadForm:FormGroup;
    constructor(private uploadService:UploadService ) { }
    file:File;
  
  ngOnInit() 
  {
    this.excelUploadForm=new FormGroup(
      {
        excelFileUpload:new FormControl("",Validators.required)
      }
    );
  }

    onFileChange(e)
    {
      this.file=e.target.files[0];
    }

    uploadData()
    {
      const uploadSheetData=new FormData();
      uploadSheetData.append("stockSheet",this.file,this.file.name);
      this.uploadService.uploadStockSheet(uploadSheetData).subscribe(data => {
        alert('File Uploaded Successfully');
      })
    }
}
