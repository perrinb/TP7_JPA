import {Component, OnInit, ViewChild} from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http, Headers } from '@angular/http';
import {ModalDirective} from "ng2-bootstrap";

@Component({
  selector: 'electronicdevice',
  templateUrl: './electronicdevice.component.html',
  styleUrls: ['./electronicdevice.component.css']
})
export class ElectronicdeviceComponent implements OnInit {

  consumption:any;
  fonction:any;
  idHome:any;

  electronicdevices;
  homes;

  @ViewChild('autoShownModal') public autoShownModal:ModalDirective;
  public isModalShown:boolean = false;

  constructor(private http: Http) {
  }

  ngOnInit() {
      this.getElectronicDevices();
      this.getHomes();
  }

  public showModal():void {
    this.isModalShown = true;
  }

  public hideModal():void {
    this.autoShownModal.hide();
  }

  public onHidden():void {
    this.isModalShown = false;
  }



  addElectronicDevice() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      var content = JSON.stringify({
        consumption: this.consumption,
        fonction: this.fonction,
        idHome: this.idHome,
      });

      return this.http.put('/rest/electronicdevice/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getElectronicDeviceById(){
    this.electronicdevices = this.http.get('/rest/electronicdevice/search/1');
  }

  getElectronicDevices(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/electronicdevice/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.electronicdevices = data; console.log(data); },
        err => { console.log(err); }
      );
  }

  getHomes(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/home/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.homes = data; console.log(data); },
        err => { console.log(err); }
      );
  }
}
