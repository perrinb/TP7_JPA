import { Pipe, PipeTransform } from '@angular/core';

import { Person } from './person/person.model';

@Pipe({
  name: 'FilterPipe',
  pure: false
})
export class FilterPipe implements PipeTransform {
  transform(items: Person[], filter: Person): Person[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: Person) => this.applyFilter(item, filter));
  }

  /**
   * Perform the filtering.
   *
   * @param {Book} book The book to compare to the filter.
   * @param {Book} filter The filter to apply.
   * @return {boolean} True if book satisfies filters, false if not.
   */
  applyFilter(person: Person, filter: Person): boolean {
    if (filter.lastname && person.lastname.toLowerCase().indexOf(filter.lastname.toLowerCase()) === -1) {
      return false;
    }
    return true;
  }
}
