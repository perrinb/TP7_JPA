import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public navbarCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  toggleNavbar() {
    this.navbarCollapsed = !this.navbarCollapsed;
  }
}
