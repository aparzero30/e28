PGDMP                         {            e28    15.1    15.1 !               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    19973    e28    DATABASE     ~   CREATE DATABASE e28 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE e28;
                postgres    false            ?            1259    20027    course    TABLE        CREATE TABLE public.course (
    id integer NOT NULL,
    course_name character varying(255) NOT NULL,
    description text
);
    DROP TABLE public.course;
       public         heap    postgres    false            ?            1259    20026    course_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.course_id_seq;
       public          postgres    false    219                       0    0    course_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;
          public          postgres    false    218            ?            1259    20006 
   course_seq    SEQUENCE     t   CREATE SEQUENCE public.course_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.course_seq;
       public          postgres    false            ?            1259    19996    student    TABLE       CREATE TABLE public.student (
    id integer NOT NULL,
    course character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    email character varying(255),
    level integer,
    birthday character varying(255)
);
    DROP TABLE public.student;
       public         heap    postgres    false            ?            1259    20035    student_course    TABLE     ?   CREATE TABLE public.student_course (
    student_id integer NOT NULL,
    course_id integer NOT NULL,
    id integer NOT NULL
);
 "   DROP TABLE public.student_course;
       public         heap    postgres    false            ?            1259    20054    student_course_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.student_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.student_course_id_seq;
       public          postgres    false    220                       0    0    student_course_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.student_course_id_seq OWNED BY public.student_course.id;
          public          postgres    false    222            ?            1259    20050    student_course_seq    SEQUENCE     |   CREATE SEQUENCE public.student_course_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.student_course_seq;
       public          postgres    false            ?            1259    19995    student_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.student_id_seq;
       public          postgres    false    215                       0    0    student_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.student_id_seq OWNED BY public.student.id;
          public          postgres    false    214            ?            1259    20004    student_seq    SEQUENCE     u   CREATE SEQUENCE public.student_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.student_seq;
       public          postgres    false            s           2604    20030 	   course id    DEFAULT     f   ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);
 8   ALTER TABLE public.course ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            r           2604    19999 
   student id    DEFAULT     h   ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);
 9   ALTER TABLE public.student ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            t           2604    20055    student_course id    DEFAULT     v   ALTER TABLE ONLY public.student_course ALTER COLUMN id SET DEFAULT nextval('public.student_course_id_seq'::regclass);
 @   ALTER TABLE public.student_course ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    220                      0    20027    course 
   TABLE DATA           >   COPY public.course (id, course_name, description) FROM stdin;
    public          postgres    false    219   4#                 0    19996    student 
   TABLE DATA           \   COPY public.student (id, course, first_name, last_name, email, level, birthday) FROM stdin;
    public          postgres    false    215   ?#                 0    20035    student_course 
   TABLE DATA           C   COPY public.student_course (student_id, course_id, id) FROM stdin;
    public          postgres    false    220   ?#                  0    0    course_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.course_id_seq', 1, false);
          public          postgres    false    218                       0    0 
   course_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.course_seq', 251, true);
          public          postgres    false    217                       0    0    student_course_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.student_course_id_seq', 1, false);
          public          postgres    false    222                        0    0    student_course_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.student_course_seq', 101, true);
          public          postgres    false    221            !           0    0    student_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.student_id_seq', 1, false);
          public          postgres    false    214            "           0    0    student_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.student_seq', 301, true);
          public          postgres    false    216            x           2606    20034    course course_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.course DROP CONSTRAINT course_pkey;
       public            postgres    false    219            z           2606    20039 "   student_course student_course_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT student_course_pkey PRIMARY KEY (student_id, course_id);
 L   ALTER TABLE ONLY public.student_course DROP CONSTRAINT student_course_pkey;
       public            postgres    false    220    220            v           2606    20003    student student_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public            postgres    false    215            {           2606    20045 ,   student_course student_course_course_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT student_course_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);
 V   ALTER TABLE ONLY public.student_course DROP CONSTRAINT student_course_course_id_fkey;
       public          postgres    false    219    3192    220            |           2606    20040 -   student_course student_course_student_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT student_course_student_id_fkey FOREIGN KEY (student_id) REFERENCES public.student(id);
 W   ALTER TABLE ONLY public.student_course DROP CONSTRAINT student_course_student_id_fkey;
       public          postgres    false    220    215    3190               Z   x?345?t+??Q.)JL?VpI-K??/?M?+??M??,J,P?sT?2??8??sJKR?\??3?RS?2??9Ks???r?
c???? ??         !   x?320????LCCNC]#]KK?=... Q?
            x?320?4a?=... ?     