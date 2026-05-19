export interface villano {
  name: string;
  url: string;
}

export interface libro {
  id: number;
  Year: number;
  Title: string | undefined;
  handle: string | undefined;
  Publisher: string | undefined;
  ISBN: string | undefined;
  Pages: number;
  Notes: string[];
  created_at: string | undefined;
  villains: villano[];
}