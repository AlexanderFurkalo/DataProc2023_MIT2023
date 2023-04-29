import { Boots } from "../boots";
import { PageNumbers } from "./PageNumbers";
import { Root } from "./Root";

export interface Http {
    _embedded: {
      boots: Boots[];
    };
    _links: Root;
    page: PageNumbers;
  }