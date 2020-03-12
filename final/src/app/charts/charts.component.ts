import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { UploadService } from '../service/upload.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent
{
   // compareData: CompareFormData;
   //  constructor(private stockPriceService: UploadService, private route: ActivatedRoute) { }
   //  chartOne = Highcharts;
   //  chartOneOptions: any;
   //  getFirstDataComplete: boolean = false;
   //  getSecondDataComplete: boolean = false;
   //  ngOnInit() {
   //      this.compareData = JSON.parse(this.route.snapshot.queryParams.formData);
   //      let series: any = []
   //          let categories: any[] = [];
   //          this.stockPriceService.getCompanyStockPricesBetween(this.compareData.companies[0].companyCode, this.compareData.companies[0].stockExchange, this.compareData.periods[0].fromDate, this.compareData.periods[0].toDate, this.compareData.periodicity).subscribe(data => {
   //              let companyOneData: any[] = [];
   //              data.forEach((stockPrice: StockPriceData) => {
   //                  categories.push(stockPrice.dataPoint);
   //                  companyOneData.push(stockPrice.dataValue)
   //              })
   //              let seriesDataMemberOne = {
   //                  name: this.compareData.companies[0].companyCode + " (" + this.compareData.companies[0].stockExchange + ")",
   //                  data: companyOneData
   //              }
   //              series[0] = seriesDataMemberOne;
   //              this.getFirstDataComplete = true;
   //          });
   //          this.stockPriceService.getCompanyStockPricesBetween(this.compareData.companies[1].companyCode, this.compareData.companies[1].stockExchange, this.compareData.periods[0].fromDate, this.compareData.periods[0].toDate, this.compareData.periodicity).subscribe(data => {
   //              let companyTwoData: any[] = [];
   //              data.forEach((stockPrice: StockPriceData) => {
   //                  if (categories.includes(stockPrice.dataPoint)) {
   //                      companyTwoData.push(stockPrice.dataValue)
   //                  }
   //              })
   //              let seriesDataMemberTwo = {
   //                  name: this.compareData.companies[1].companyCode + " (" + this.compareData.companies[1].stockExchange + ")",
   //                  data: companyTwoData
   //              }
   //              series[1] = seriesDataMemberTwo;
   //              this.getSecondDataComplete = true;
   //          });
   //          this.chartOneOptions = {
   //              chart: {
   //                  type: "column"
   //              },
   //              title: {
   //                  text: "Stock Comparision Chart"
   //              },
   //              xAxis: {
   //                  categories: categories
   //              },
   //              yAxis: {
   //                  title: {
   //                      text: "Stock Price"
   //                  }
   //              },
   //              series: series
   //          }
   //      }
}